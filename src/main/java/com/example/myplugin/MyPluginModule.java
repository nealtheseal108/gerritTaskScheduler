package com.example.myplugin;

import com.google.inject.servlet.ServletModule;

public class MyPluginModule extends ServletModule {
  @Override
  protected void configureServlets() {
    serve("/schedule").with(ScheduleServlet.class);
  }
}
