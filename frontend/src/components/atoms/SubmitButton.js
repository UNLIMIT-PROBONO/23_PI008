import React from "react";
import "../css/SubmitButton.css";
import styled from "styled-components";

export const SubmitButton = (props) => {
  return (
    <Div>
      <button class="btn-outline-primary" type="submit" onClick={props.onClick}>
        <span>{props.label}</span>
      </button>
    </Div>
  );
};

const Div = styled.div`
  margin-top: 50px;
  margin-left: 15px;
`