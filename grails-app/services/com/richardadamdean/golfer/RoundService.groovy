package com.richardadamdean.golfer

import org.springframework.transaction.annotation.Transactional

class RoundService {

  @Transactional(readOnly = true)
  def getRoundsForUser(user){
    Round.findAllByUser(user, [sort: 'created_at', order: 'desc'])
  }

}
