package com.richardadamdean.golfer

class Course {

  String name
  Date created_at
  Date updated_at

  static hasMany = [rounds: Round, holes: Hole]

  static mapping = {
    table 'courses'
    version false
    holes lazy: false
  }

}
