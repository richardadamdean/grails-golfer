package com.richardadamdean.golfer.pages

import geb.Page

class ShowPage extends Page {

  static at = {
    heading.text() ==~ /Show Round/
  }


}
