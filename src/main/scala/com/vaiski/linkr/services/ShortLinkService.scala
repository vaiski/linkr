package com.vaiski.linkr.services

import com.outworkers.phantom.connectors.CassandraConnection
import com.outworkers.phantom.dsl._
import com.vaiski.linkr.common.utils.cassandra.DefaultConnection
import com.vaiski.linkr.model.{ShortLinkClicks, ShortLinks}

/**
  * Created by vaiski on 8.4.2017.
  */

object  ShortLinkService extends ShortLinkService(DefaultConnection.connector)

abstract class ShortLinkService(val keyspace: CassandraConnection) extends Database[ShortLinkService](keyspace) {
  object shortLinks extends ShortLinks with keyspace.Connector
  object shortLinkClicks extends ShortLinkClicks with keyspace.Connector
}
