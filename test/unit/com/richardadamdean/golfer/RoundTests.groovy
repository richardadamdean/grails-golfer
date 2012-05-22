package com.richardadamdean.golfer

import grails.test.mixin.*
import org.junit.*

@TestFor(Round)
@Mock([Course, RoundHole, User])
class RoundTests {

    def course

    @Before
    void setUp() {
      new User(id: 1, handicap: 10).save(flush: true, validate: false)
      course = new Course(id: 1)
      course.holes = [new Hole(number: 10), new Hole(number: 11)]
      course.save(validate: false)
    }

    void testFromCourse() {
      assert Round.count() == 0
      def round = Round.fromCourse(1, true)
      assert round.handicap == 10
      assert round.round_holes.size() == 2
      assert round.course == course
      assert Round.count() == 1
    }
}
