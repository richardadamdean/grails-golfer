package com.richardadamdean.golfer

import geb.spock.GebReportingSpec
import spock.lang.*
import geb.Page
import com.richardadamdean.golfer.pages.*
import grails.test.mixin.TestFor
import geb.spock.GebSpec

//@Stepwise
class RoundsSpec extends GebReportingSpec {

  @Shared
  def richard

  @Shared
  def course

  def setupSpec(){
    richard = new User(id: 1, name: "Richard", updated_at: new Date(), created_at: new Date(), handicap: 2).save(flush: true)
    course = new Course(id: 1, name: 'My Course', updated_at: new Date(), created_at: new Date())
    course.save(validate: false)
    def hole1 = new Hole(holeNumber: 10, course: course).save()
    def hole2 = new Hole(holeNumber: 11, course: course).save()
    course.holes = [hole1, hole2]
    course.save()
  }

  def "should show no rows when there are no rounds"() {
    when:
      to ListPage

    then:
      rounds.size() == 0
      at ListPage
  }

  def "should show rows of existing rounds"(){
    setup:
      new Round(user: richard, course: course, updated_at: new Date(), created_at: new Date()).save(flush: true)

    when:
      to ListPage

    then:
      rounds.size() == 1
  }

  def "should begin the round creation"(){

    when:
      to ListPage
      newRoundButton.click()
      handicap << "18"
      createButton.click()

    then:
      at ShowPage
  }

}