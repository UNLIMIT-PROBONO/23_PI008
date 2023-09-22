import React from "react";
import "../css/Text.css";

export const Text = (props) => {
  return (
    <div
      style={{
        fontSize: props.fontSize ? props.fontSize : "16px",
        margin: "4px",
        alignContent: "center",
        justifyItems: "center",
        whiteSpace: "pre-line",
      }}
    >
      {props.label}
    </div>
  );
};

export const HrefText = (props) => {
  return (
    <div
      class="text-href"
      style={{
        fontSize: props.fontSize ? props.fontSize : "16px",
        margin: "4px",
        alignContent: "center",
        justifyItems: "center",
        textAlign: "center",
        whiteSpace: "pre-line",
      }}
    >
      <a href={props.to}> {props.label} </a>
    </div>
  );
};
