import { List } from 'antd';
import React from 'react';
import { Text } from '../../atoms/Text';
import styled from 'styled-components';

const ListBox = styled.div`
  width: 100%;
  flex-wrap: wrap;
`

export const ScheduleList = (props) => {
  const dataList = props.data;
  const headText = (<Text label={props.label}/>);

  return (
    <ListBox>
      <List
        header={headText}
        bordered
        itemLayout='horizontal'
        dataSource={dataList}
        renderItem={(item, index) => (
          <List.Item>
            <List.Item.Meta
              title={item.title}
              description={item.content}
            />
          </List.Item>
        )}
      />
    </ListBox>
  )
}