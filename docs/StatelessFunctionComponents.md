# Functions as Stateless Components

React 0.14 introduced [stateless functional components](https://facebook.github.io/react/blog/2015/10/07/react-v0.14.html#stateless-functional-components) .

>In idiomatic React code, most of the components you write will be stateless, simply composing other components. We’re introducing a new, simpler syntax for these components where you can take props as an argument and return the element you want to render



#### Stateless Component

```scala

 object StatelessComponent {
  
  val component = (props: String) => Text()(s"Hello Stateless ${props}")
 
  def apply(props : String) = createStatelessElement(component,props)
  
 }

```

##### Stateless Component With Children

```scala

 object StatelessComponent {

  val component = (props: String,children : ReactElement) => Text()(s"Hello Stateless ${props}",children)

  def apply(props : String)(children : ReactNode*) = createStatelessElementWithChildren(component,props)(children: _*)

 }

```

