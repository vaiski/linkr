package com.vaiski.linkr.resources

import akka.http.scaladsl.server.Route
import com.vaiski.linkr.entities.ShortLink
import com.vaiski.linkr.routing.JsonResource
import com.vaiski.linkr.services.ShortLinkService

trait ShortLinkResource extends JsonResource {

  def shortLinkRoutes: Route = pathPrefix("links") {
    pathEnd {
      post {
        entity(as[ShortLink]) { shortLink =>
          complete(ShortLinkService.shortLinks.store(shortLink))
        }
      }
    } ~
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
