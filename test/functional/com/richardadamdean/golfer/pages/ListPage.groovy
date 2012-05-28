package com.richardadamdean.golfer.pages

import geb.Module
import geb.Page

class ListPage extends Page {

  static url = "round/list"
  static at = {title ==~ /Person List/}

  static content = {
    newRoundButton(to: CreatePage) { $('a', class: 'create')}
//    newPersonButton(to: CreatePage) { $("a", text: "New Person") }
    roundList { $("div.content table", 0) }
//    personRow { module PersonRow, personRows[it] }
    rounds(required: false) { roundList.find("tbody").find("tr") }
  }
}

class PersonRow extends Module {
//  static content = {
//    cell { $("td", it) }
//    cellText { cell(it).text() }
//    cellHrefText{ cell(it).find('a').text() }
//    enabled { Boolean.valueOf(cellHrefText(0)) }
//    firstName { cellText(1) }
//    lastName { cellText(2) }
//    showLink(to: ShowPage) { cell(0).find("a") }
//  }
}