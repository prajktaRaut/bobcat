/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2019 Cognifide Ltd.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.cognifide.qa.bb.aem.core.modules.fields;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DefaultCheckbox;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DefaultImage;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DefaultMultifield;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DefaultMultifieldItem;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DefaultPathBrowser;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DefaultRadioGroup;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DefaultRichText;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DefaultSelect;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DefaultTextfield;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DialogField;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.Fields;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.text.DefaultFontFormat;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.text.DefaultJustifyDialogPanel;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.text.ListDialogPanel;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class FieldsRegistryModule extends AbstractModule {
  private static final Logger LOG = LoggerFactory.getLogger(FieldsRegistryModule.class);

  @Override
  protected void configure() {
    LOG.debug("Configuring Bobcat module: {}", getClass().getSimpleName());

    LOG.debug("Registering dialog fields...");
    MapBinder<String, DialogField> fieldsBinder = MapBinder
        .newMapBinder(binder(), String.class, DialogField.class);
    registerField(fieldsBinder, Fields.CHECKBOX, DefaultCheckbox.class);
    registerField(fieldsBinder, Fields.TEXTFIELD, DefaultTextfield.class);
    registerField(fieldsBinder, Fields.IMAGE, DefaultImage.class);
    registerField(fieldsBinder, Fields.PATHBROWSER, DefaultPathBrowser.class);
    registerField(fieldsBinder, Fields.SELECT, DefaultSelect.class);
    registerField(fieldsBinder, Fields.RICHTEXT, DefaultRichText.class);
    registerField(fieldsBinder, Fields.MULTIFIELD, DefaultMultifield.class);
    registerField(fieldsBinder, Fields.MULTIFIELD_ITEM, DefaultMultifieldItem.class);
    registerField(fieldsBinder, Fields.RICHTEXT_FONT_FORMAT, DefaultFontFormat.class);
    registerField(fieldsBinder, Fields.RICHTEXT_JUSTIFY, DefaultJustifyDialogPanel.class);
    registerField(fieldsBinder, Fields.RICHTEXT_LIST, ListDialogPanel.class);
    registerField(fieldsBinder, Fields.RADIO_GROUP, DefaultRadioGroup.class);
  }

  private void registerField(MapBinder<String, DialogField> binder, String name,
      Class<? extends DialogField> type) {
    LOG.debug("- registering field: {} [{}]", name, type);
    binder.addBinding(name).to(type);
  }
}
