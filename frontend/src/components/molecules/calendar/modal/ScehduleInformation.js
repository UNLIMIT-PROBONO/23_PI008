import { Row } from "antd";
import React, { useState } from "react";
import { TaggedInputField } from "../../auth/TaggedInputField";
import { SelectBox } from "../../../atoms/SelectBox";

export const ScheduleInformation = (props) => {
  const handleParent = props.inputHandler;
  const [form, setForm] = useState(props.values);

  const handleInput = (tag) => {
    return (event) => {
      form[tag] = event.target.value;
      handleParent(form);
    };
  };

  const targetHandler = (data) => {
    form.targetId = data;
  };

  return (
    <>
      <Row>
        <SelectBox
          targetInfos={props.targetInfos}
          targetHandler={targetHandler}
          selection={form.targetId}
        />
      </Row>
      <Row>
        <TaggedInputField label="제목" onChange={handleInput("title")} />
      </Row>
      <Row>
        <TaggedInputField label="내용" onChange={handleInput("content")} />
      </Row>
    </>
  );
};
