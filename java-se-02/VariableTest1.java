/*
Java�������������

һ���������������������֣�

	�����������ͣ�
		���ͣ�byte \ short \ int \ long
		�����ͣ�float \ double
		�ַ��ͣ�char
		�����ͣ�boolean


	�����������ͣ�
		��(class)
		�ӿ�(interface)
		����(array)


��������������������λ�ã�
		��Ա����  vs  �ֲ�����
*/
class VariableTest1 {
	public static void main(String[] args) {
		//1. ���ͣ�byte(1�ֽ�=8bit) \ short(2�ֽ�) \ int(4�ֽ�) \ long(8�ֽ�)
		//�� byte��Χ��-128 ~ 127
		//
		byte b1 = 12;
		byte b2 = -128;
		//b2 = 128;//���벻ͨ��
		System.out.println(b1);
		System.out.println(b2);
		// �� ����long�ͱ�����������"l"��"L"��β
		// �� ͨ�����������ͱ���ʱ��ʹ��int�͡�
		short s1 = 128;
		int i1 = 1234;
		long l1 = 3414234324L;
		System.out.println(l1);

		//2. �����ͣ�float(4�ֽ�) \ double(8�ֽ�)
		//�� �����ͣ���ʾ��С�������ֵ
		//�� float��ʾ��ֵ�ķ�Χ��long����

		double d1 = 123.3;
		System.out.println(d1 + 1);
		//�� ����float���ͱ���ʱ������Ҫ��"f"��"F"��β
		float f1 = 12.3F;
		System.out.println(f1);
		//�� ͨ�������帡���ͱ���ʱ��ʹ��double�͡�

		//3. �ַ��ͣ�char (1�ַ�=2�ֽ�)
		//�� ����char�ͱ�����ͨ��ʹ��һ��'',�ڲ�ֻ��дһ���ַ�
		char c1 = 'a';
		//���벻ͨ��
		//c1 = 'AB';
		System.out.println(c1);

		char c2 = '1';
		char c3 = '��';
		char c4 = '��';
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);

		//�� ��ʾ��ʽ��1.����һ���ַ� 2.ת���ַ� 3.ֱ��ʹ�� Unicode ֵ����ʾ�ַ��ͳ���
		char c5 = '\n';//���з�
		c5 = '\t';//�Ʊ��
		System.out.print("hello" + c5);
		System.out.println("world");

		char c6 = '\u0043';
		System.out.println(c6);

		//4.�����ͣ�boolean
		//�� ֻ��ȡ����ֵ֮һ��true �� false
		//�� �����������жϡ�ѭ���ṹ��ʹ��
		boolean bb1 = true;
		System.out.println(bb1);

		boolean isMarried = true;
		if(isMarried){
			System.out.println("��Ͳ��ܲμ�\"����\"party�ˣ�\\n���ź�");
		}else{
			System.out.println("����Զ�̸̸Ů���ѣ�");
		}

	}
}
