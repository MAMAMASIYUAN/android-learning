public class BoxUnbox {
    public static void main(String[] args){
        Integer i = 10; //װ��
        int index = i;  //����
    }
}

//javap -c BoxUnbox.class






















/*
�ӷ�����õ����ֽ������ݿ��Կ�������װ���ʱ���Զ����õ���Integer��valueOf(int)���������ڲ����ʱ���Զ����õ���Integer��intValue������

װ�������ͨ�����ð�װ����valueOf����ʵ�ֵģ������������ͨ�����ð�װ����xxxValue����ʵ�ֵġ���xxx�����Ӧ�Ļ����������ͣ���
*/