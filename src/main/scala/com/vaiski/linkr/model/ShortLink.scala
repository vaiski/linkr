package com.vaiski.linkr.model

import com.outworkers.phantom.dsl._
import com.vaiski.linkr.entities.ShortLink

import scala.concurrent.Future

/**
  * Created by vaiski on 8.4.2017.
  */

class ShortLinksSchema extends CassandraTable[ShortLinksSchema, ShortLink] {

  override lazy val tableName = "short_links"

  object id extends StringColumn(this) with PartitionKey
  object url extends StringColumn(this)
  object createdAt extends DateTimeColumn(this) {
    override lazy val name = "created_at"
  }

  override def fromRow(r: Row): ShortLink = ShortLink(id(r), url(r), createdAt(r))
}

abstract class ShortLinks extends ShortLinksSchema with RootConnector {
  def findById(id: String): Future[Option[ShortLink]] = {
    select.where(_.id eqs id).one()
  }
}
