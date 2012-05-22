package com.richardadamdean.golfer

class User {

  String name
  Date created_at
  Date updated_at
  int handicap

  static hasMany = [rounds: Round]

  static mapping = {
    table 'users'
    version false
  }
}
