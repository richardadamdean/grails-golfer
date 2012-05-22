package com.richardadamdean.golfer

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.plugin.spock.UnitSpec

@TestFor(Round)
@Mock([Course, RoundHole, User])
class RoundSpec extends UnitSpec{

  def 'should create a new round based off the given course'(){

    setup:
      new User(id: 1, handicap: 10).save(flush: true, validate: false)
      def course = new Course(id: 1, holes: [new Hole(number: 10), new Hole(number: 11)])
      course.save(validate: false)

    when:
      def round = Round.fromCourse(course.id, true)

    then:
      Round.count() == 1
      round.handicap == 10
      round.round_holes.size() == 2
      round.course == course
  }

  def 'validate that a round has a valid handicap or none specified'(){

    setup:
      def user = new User(id: 1, handicap: 10).save(flush: true, validate: false)
      def course = new Course(id: 1, holes: [new Hole(number: 10), new Hole(number: 11)])

    when:
      def round = new Round(handicap: handicap, course: course, user: user)
      round.validate()

    then:
      round.hasErrors() == errors

    where:
      handicap | errors
      -1       | true
      5        | false
      37       | true
      null     | false
  }
}
