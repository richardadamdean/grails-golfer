package com.richardadamdean.golfer

class Round {

    Integer handicap
    Date created_at = new Date()
    Date updated_at = new Date()

    static belongsTo = [course:Course, user:User]
    static hasMany = [round_holes: RoundHole]

    static constraints = {
      handicap nullable: true, range: 0..36
    }

    static mapping = {
      table 'rounds'
      version false
    }

    def static Round fromCourse(long course_id, save=false){
      def round = this.newInstance()
      round.course = Course.get(course_id)
      round.round_holes = round.course.holes.collect{ new RoundHole(hole: it, round: round)}
      round.user = User.findById(1)
      round.handicap = round.user?.handicap
      if(save) round.save(flush: true)
      round
    }

    def String toString(){
      "${user.name} playing ${course.name} off ${handicap}"
    }
}
