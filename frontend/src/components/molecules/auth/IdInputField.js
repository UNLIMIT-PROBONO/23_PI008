import React from "react";
import "../../css/InputField.css";
import { Text } from "../../atoms/Text";

export const IdInputField = (props) => {
  return (
    <div style={{ margin: "10px" }}>
      <Text label={props.label} />
      <div>
        <input
          class="inputField"
          style={{
            width: "195px",
            height: "40px",
            marginRight: "20px",
            paddingLeft: "15px",
            paddingRight: "15px",
          }}
          onChange={props.onChange}
          disabled={props.lock ? true : false}
        />
        <button
          class="btn-outline-primary"
          style={{
            width: "90px",
            height: "47px",
            fontSize: "14px",
          }}
          onClick={props.onClick}
          disabled={props.lock ? true : false}
        >
          <span>중복 확인</span>
        </button>
      </div>
    </div>
  );
};