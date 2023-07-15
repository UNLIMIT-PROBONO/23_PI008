import { Button } from "antd";
import React from "react";

export function ModalButton(props) {
  return (
    <>
      <Button type={props.type} onClick={props.onClick}>
        {props.label}
      </Button>
    </>
  );
}
