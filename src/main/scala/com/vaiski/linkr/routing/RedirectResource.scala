package com.vaiski.linkr.routing

import akka.http.scaladsl.marshalling.{ToResponseMarshallable, ToResponseMarshaller}
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.{Directives, Route}

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by vaiski on 13.4.2017.
  */
trait RedirectResource extends Directives {

}
