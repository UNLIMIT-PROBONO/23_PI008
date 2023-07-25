import React from "react";
import { InputField } from "../../atoms/InputField";

export const LoginInputField = (props) => {
  return (
    <div>
      {props.label}
      <InputField
        class="input-login"
        inputType={props.inputType}
        value={props.value}
        onChange={props.onChange}
      />
    </div>
  );
};
