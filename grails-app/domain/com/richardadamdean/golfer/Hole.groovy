package com.richardadamdean.golfer

class Hole {

  Integer holeNumber

  static belongsTo = [course:Course]

  static mapping = {
    table 'holes'
    version false
    holeNumber column: 'number'
  }

}
