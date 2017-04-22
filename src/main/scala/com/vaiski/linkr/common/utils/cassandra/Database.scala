package com.vaiski.linkr.common.utils.cassandra

import com.outworkers.phantom.dsl._
import com.vaiski.linkr.common.utils.AppConfiguration

import scala.collection.JavaConverters._

/**
  * Created by vaiski on 10.4.2017.
  */

object DefaultConnection extends AppConfiguration {
  val hosts = config.getStringList("cassandra.hosts").asScala

  val connector = ContactPoints(hosts).keySpace("linkr")
}
