import React from "react";
import "../../css/InputField.css";
import { InputField } from "../../atoms/InputField";
import { Text } from "../../atoms/Text";

export const TaggedInputField = (props) => {
  return (
    <div class="signUp">
      <div class="tag">
        <Text label={props.label} />
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
