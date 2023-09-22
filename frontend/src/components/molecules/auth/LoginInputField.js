import React from "react";
import { InputField } from "../../atoms/InputField";
import { Text } from "../../atoms/Text";

export const LoginInputField = (props) => {
  return (
    <div style={{marginTop:"40px"}}>
      <Text label={props.label} fontSize={"20px"}/>
      <InputField
        class="input-login"
        inputType={props.inputType}
        value={props.value}
        onChange={props.onChange}
      />
    </div>
  );
};
