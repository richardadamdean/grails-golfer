package com.richardadamdean.golfer.pages

import geb.Page

class ShowPage extends Page {

  static at = {title == /Show Round/}

  static content = {
    // this is a crap selector, but the generated views don't give us much to play with
    handicap{$('span', 'aria-labelledby': 'handicap-label')} 
  }
}
