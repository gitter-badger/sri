package sri.relay.webexamples

import org.scalajs.dom
import sri.relay.Relay
import sri.relay.container.RelayRootContainer
import sri.relay.network.DefaultNetworkLayer
import sri.relay.webexamples.starwars.components.{StarWarsApp, StarWarsShip}
import sri.relay.webexamples.starwars.queries.StarWarsAppHomeQuery
import sri.web.ReactDOM

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object RelayWebApp extends JSApp {


  @JSExport
  override def main(): Unit = {

//    Relay.injectNetworkLayer(new DefaultNetworkLayer("http://localhost:8088/graphql"))
    Relay.injectNetworkLayer(new DefaultNetworkLayer("http://www.graphqlHub.com/graphql"))

    //            js.Dynamic.global.Component = HNItem.container
            js.Dynamic.global.StarWarsShip = StarWarsShip.container
    //    val afunc: js.Function = () => js.eval(RelayQL( """fragment on Faction @relay(plural: true) { name,
    //                                                         ships(first: 10) {
    //                                                           edges {
    //                                                             node {
    //                                                               ${StarWarsShip.getFragment('ship')}
    //                                                             }
    //                                                           }
    //                                                         }
    //                                                       }"""))
    //    val container = Relay.createContainer(StarApp.ctor, new RelayContainerConfig {
    //      override var fragments: Dictionary[js.Function] = js.Dictionary("factions" -> afunc)
    //    })
    //

    //       val queryFunc : js.Function  = () => js.eval(RelayQL( """query { factions(names: $factionNames)}"""))
    //       js.constructorOf[RQuery].routeName = "StarWarsAppHomeRoute"
    //       js.constructorOf[RQuery].queries = js.Dictionary("factions" -> queryFunc)

    //       val route = new RQuery(js.Dictionary("factionNames" -> js.Array("empire", "rebels")))
    //    val rc = RelayRootContainer(TodoApp.container, TodoQuery())
    //    val rc = RelayRootContainer(HNItem.container,HNQuery())
            val rc = RelayRootContainer(StarWarsApp.container, StarWarsAppHomeQuery(js.Array("empire", "rebels")))
    //

//    val rc = RelayRootContainer(StarterkitApp.container, StarterkitQuery.route)
    ReactDOM.renderJS(rc, dom.document.getElementById("container"))
    //    ReactDOM.renderJS(rc, dom.document.getElementById("container"))
    //    ReactDOM.render(HelloWeb(), dom.document.getElementById("container"))
    //    ReactDOM.render(Parent(), dom.document.getElementById("container"))

    //    ReactDOM.renderJS(AppRouter.router, dom.document.getElementById("container"))
  }


}

