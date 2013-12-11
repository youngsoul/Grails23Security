package com.bluelobsterstudios

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class HomeController {

  def index() {render "home" }

  @Secured('ROLE_ADMIN')
  def adminOnly() {render "admin only"}
}
