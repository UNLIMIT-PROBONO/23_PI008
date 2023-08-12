import React from "react";
import "../../css/InputField.css";
import { InputField } from "../../atoms/InputField";

export const TaggedInputField = (props) => {
  return (
    <div class="signUp">
      <div class="tag">
        <label>{props.label}</label>
      </div>
      <div class="row">
        <InputField
          value={props.value}
          inputType={props.inputType}
          holder={props.holder}
          onChange={props.onChange}
        />
      </div>
    </div>
  );
};
