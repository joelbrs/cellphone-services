package br.com.joelbrs.CellphoneServices.enums;

public enum ServiceItemStatus {
    PAID(1L),
    PENDING_PAYMENT(2L),
    DELIVERED(3L),
    CANCELED(4L);

    private Long code;

    ServiceItemStatus(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

    public static ServiceItemStatus valueOf(Long id) {
        for (ServiceItemStatus status : values()) {
            if (status.getCode() == id) {
                return status;
            }
        }
        return null;
    }
}
