// Generated code from Butter Knife. Do not modify!
package com.kupferwerk.coppercard.session;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SessionActivity$$ViewBinder<T extends com.kupferwerk.coppercard.session.SessionActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558524, "field 'selectedCard'");
    target.selectedCard = view;
  }

  @Override public void unbind(T target) {
    target.selectedCard = null;
  }
}
