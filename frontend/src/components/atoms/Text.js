import React from "react";
import "../css/Text.css";

export const Text = (props) => {
  return <div>{props.label}</div>;
};

export const HrefText = (props) => {
  return (
    <div class="text-href">
      <a href={props.to}> {props.label} </a>
    </div>
  );
};
