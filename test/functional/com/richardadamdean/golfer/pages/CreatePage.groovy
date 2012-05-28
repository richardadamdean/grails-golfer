package com.richardadamdean.golfer.pages

import geb.Page

class CreatePage extends Page{

  static at = {title == /Create Round/}

  static content = {
    handicap{$('#handicap')}
    createButton(to: ShowPage){$('#create')}
  }

}
