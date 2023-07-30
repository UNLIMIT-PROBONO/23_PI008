import { Row } from "antd";
import React from "react";
import { TaggedInputField } from "../../auth/TaggedInputField";

export const ScheduleInformation = (props) => {
  return (
    <>
      <Row>
        <TaggedInputField
          label="제목"
          value={props.value}
          onChange={props.onChange}
        />
      </Row>
      <Row>
        <TaggedInputField
          label="내용"
          value={props.value}
          onChange={props.onChange}
        />
      </Row>
    </>
  );
};
