package com.richardadamdean.golfer

import geb.spock.GebReportingSpec
import spock.lang.*
import geb.Page
import com.richardadamdean.golfer.pages.*
import grails.test.mixin.TestFor
import geb.spock.GebSpec

@Stepwise
class RoundsSpec extends GebReportingSpec {

  def "there are no rounds"() {

    setup:
      new User(id: 1, name: "Richard", updated_at: new Date(), created_at: new Date(), handicap: 2).save(flush: true)
      def course = new Course(id: 1, name: 'My Course', updated_at: new Date(), created_at: new Date())
      course.save(validate: false)
      def hole1 = new Hole(holeNumber: 10, course: course).save()
      def hole2 = new Hole(holeNumber: 11, course: course).save()
      course.holes = [hole1, hole2]
      course.save()

    when:
      def round = Round.fromCourse(course.id, false)

    then:
//      Round.count() == 1
      round.handicap == 2
      round.course == course
      round.round_holes.size() == 2
  }

}