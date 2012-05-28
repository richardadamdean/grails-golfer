package com.richardadamdean.golfer.pages

import geb.Page

class CreatePage extends Page{

  static at = {
    heading.text() ==~ /Create Round/
  }



}
