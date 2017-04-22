package com.vaiski.linkr.resources

import akka.http.scaladsl.server.Route
import com.vaiski.linkr.routing.JsonResource
import com.vaiski.linkr.services.ShortLinkService

/**
  * Created by vaiski on 8.4.2017.
  */
trait ShortLinkResource extends JsonResource {

  def shortLinkRoutes: Route = pathPrefix("links") {
    path(Segment) { id =>
      get {
        complete(ShortLinkService.shortLinks.findById(id))
      } ~
      path("clicks") {
        get {
          complete(ShortLinkService.shortLinkClicks.findByLinkId(id))
        }
      }
    }
  }

}
