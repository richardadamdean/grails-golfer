package com.richardadamdean.golfer

import grails.test.mixin.*
import org.junit.Before

@TestFor(RoundService)
class RoundServiceTests{

  def roundService

  def course
  def richard
  def robert

  @Before
  void setUp(){
    richard = new User(name: "Richard", updated_at: new Date(), created_at: new Date(), handicap: 2)
    richard.save(flush: true)

    robert = new User(name: "Robert", updated_at: new Date(), created_at: new Date(), handicap: 2)
    robert.save(flush: true)

    course = new Course(name: "testCourse", updated_at: new Date(), created_at: new Date())
    course.save(flush: true)
  }

  void testGetRoundsForUser() {
    def firstRound = new Round(user: richard, course: course).save(flush: true)
    def secondRound = new Round(user: richard, course: course).save(flush: true)
    new Round(user: robert, course: course).save(flush: true)
    assert roundService.getRoundsForUser(richard).equals(Arrays.asList(secondRound, firstRound))
  }
}
