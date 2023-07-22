import { Button } from "antd";
import React from "react";

export const ModalButton = (props) => {
  return (
    <>
      <Button type={props.type} onClick={props.onClick}>
        {props.label}
      </Button>
    </>
  );
}
