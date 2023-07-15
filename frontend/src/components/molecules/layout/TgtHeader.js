import React from "react";
import { MenuFoldOutlined, MenuUnfoldOutlined } from "@ant-design/icons";
import { Button, theme } from "antd";
import { Header } from "antd/es/layout/layout";
import { Text } from "../../atoms/Text";

export function TgtHeader(props) {
  var collapsed = props.collapsed;
  var setCollapsed = props.setCollapsed;
  var handleCollapsing = () => {
    setCollapsed(!collapsed);
  };
  const {
    token: { colorBgContainer },
  } = theme.useToken();
  // 로그아웃 왜 안 뜸?

  return (
    <div>
      <Header
        style={{ padding: 0, background: colorBgContainer, width: "100%" }}
      >
        <Button
          type="text"
          icon={collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
          onClick={handleCollapsing}
          style={{
            fontSize: "16px",
            width: 64,
            height: 64,
          }}
        />
        <Text label="로그아웃" />
      </Header>
    </div>
  );
}
