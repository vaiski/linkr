package com.vaiski.linkr.common.utils

import com.typesafe.config.ConfigFactory

trait AppConfiguration {
  val config = ConfigFactory.load()
}
