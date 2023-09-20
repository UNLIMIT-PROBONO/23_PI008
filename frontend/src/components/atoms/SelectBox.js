import { Select } from "antd";
import React from "react";

export const SelectBox = (props) => {
  const handlerParent = props.targetHandler;
  const options = props.targetInfos.map(
      (v) => ({
      value: v.targetId,
      label: v.tgName,
    })
  );

  const onChange = (value) => {
    handlerParent(value);
  };

  return (
    <>
      <Select
        defaultValue="관리 대상자 선택하기"
        style={{ width: 300 }}
        onChange={onChange}
        options={options}
      />
    </>
  );
};

// options는 {value(실제값), label(보여지는 값)} 배열
