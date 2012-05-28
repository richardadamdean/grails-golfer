package com.richardadamdean.golfer.pages

import geb.Module
import geb.Page

class ListPage extends Page {

  static url = "round/list"
  static at = {title == /Round List/}

  static content = {
    newRoundButton(to: CreatePage) { $('a', class: 'create')}
    roundList { $("div.content table", 0) }
    rounds(required: false) { roundList.find("tbody").find("tr") }
  }
}

