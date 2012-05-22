package com.richardadamdean.golfer

class RoundHole {

  static belongsTo = [round:Round, hole:Hole]

  static mapping = {
    table 'round_holes'
    version false
  }
}
