package homework.never_use_switch;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MailType {
    TYPE1(1) {
        @Override
        public String getMailWithContext(String mailContext) {
            return "Welcome mail was sent " + mailContext;
        }
    }, TYPE2(2) {
        @Override
        public String getMailWithContext(String mailContext) {
            return "Happy Birthdate mail was sent " + mailContext;
        }
    };

    private int typeIndex;

    abstract public String getMailWithContext(String mailContext);

    public static void postMailAction(MailInfo mailInfo) {
        System.out.println(findByTypeIndex(mailInfo.getMailType()).getMailWithContext(mailInfo.getContext()));
    }

    public static MailType findByTypeIndex(int typeIndex) {
        MailType[] types = values();
        for (MailType type : types) {
            if (typeIndex == type.typeIndex) {
                return type;
            }
        }
        throw new IllegalStateException(typeIndex + " is invalid");
    }
}
