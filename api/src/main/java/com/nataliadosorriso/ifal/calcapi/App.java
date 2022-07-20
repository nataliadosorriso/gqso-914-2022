package com.nataliadosorriso.ifal.calcapi;

import io.jooby.Jooby;

public class App extends Jooby {

  {

    mvc(new Controller());
  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }

}
