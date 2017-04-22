package com.vaiski.linkr.common.utils

import com.typesafe.config.ConfigFactory

/**
  * Created by vaiski on 10.4.2017.
  */
trait AppConfiguration {
  val config = ConfigFactory.load()
}
