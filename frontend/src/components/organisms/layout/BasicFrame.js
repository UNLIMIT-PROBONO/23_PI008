import { Layout } from "antd";
import React, { useState } from "react";
import { TgtSidebar } from "../../molecules/layout/TgtSidebar";
import { TgtHeader } from "../../molecules/layout/TgtHeader";
import styled from "styled-components";
import { Content } from "antd/es/layout/layout";

export const BasicFrame = (props) => {
  const [collapsed, setCollapsed] = useState(false);

  return (
    <Container>
      <Layout>
        <TgtSidebar collapsed={collapsed} />
        <Layout>
          <TgtHeader collapsed={collapsed} setCollapsed={setCollapsed} />
            <Layout>
              <Content>{props.content()}</Content>
            </Layout>
          {/* Footer */}
        </Layout>
      </Layout>
    </Container>
  );
};

const Container = styled.div`
  width: 100vw;
  height: 100vh;
`;
const ContentWrapper = styled.div`
  width: 100%;
`;
