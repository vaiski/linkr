package com.vaiski.linkr

import akka.http.scaladsl.server.Route
import com.vaiski.linkr.resources.ShortLinkResource
import com.vaiski.linkr.services.ShortLinkService

import scala.concurrent.ExecutionContext

/**
  * Created by vaiski on 8.4.2017.
  */
trait RestInterface extends Resources {
  override implicit def executionContext: ExecutionContext

  val routes: Route = shortLinkRoutes
}

trait Resources extends ShortLinkResource