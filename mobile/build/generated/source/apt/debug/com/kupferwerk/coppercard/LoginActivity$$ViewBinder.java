// Generated code from Butter Knife. Do not modify!
package com.kupferwerk.coppercard;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends com.kupferwerk.coppercard.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558513, "field 'email'");
    target.email = finder.castView(view, 2131558513, "field 'email'");
    view = finder.findRequiredView(source, 2131558512, "field 'profilePic'");
    target.profilePic = finder.castView(view, 2131558512, "field 'profilePic'");
    view = finder.findRequiredView(source, 2131558516, "field 'btnAndroid'");
    target.btnAndroid = finder.castView(view, 2131558516, "field 'btnAndroid'");
    view = finder.findRequiredView(source, 2131558517, "field 'btnIos'");
    target.btnIos = finder.castView(view, 2131558517, "field 'btnIos'");
    view = finder.findRequiredView(source, 2131558522, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131558522, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131558521, "field 'listView'");
    target.listView = finder.castView(view, 2131558521, "field 'listView'");
    view = finder.findRequiredView(source, 2131558520, "field 'spinner'");
    target.spinner = finder.castView(view, 2131558520, "field 'spinner'");
  }

  @Override public void unbind(T target) {
    target.email = null;
    target.profilePic = null;
    target.btnAndroid = null;
    target.btnIos = null;
    target.toolbar = null;
    target.listView = null;
    target.spinner = null;
  }
}
