from typing import TypeVar, Optional
from dataclasses import dataclass

T = TypeVar('T')

@dataclass
class BaseResponse:
    """
    Represents a base response object.

    Attributes:
        status (bool): The status of the response.
        message (str): The message associated with the response.
        data (Optional[T]): The additional data associated with the response.

    Class Constants:
        _OK (bool): The constant representing a successful response.
        _FAIL (bool): The constant representing a failed response.
    """

    _OK = True
    _FAIL = False
    _RETRIEVED = "Retrieved"

    status: bool
    message: str
    data: Optional[T]

    def __init__(self, status: bool, message: str, data: Optional[T] = None):
        self.status = status
        self.message = message
        self.data = data

    @staticmethod
    def ok(message: Optional[str] = _RETRIEVED, data: Optional[T] = None):
        """
        Create a successful response object.

        Args:
            message (Optional[str]): The message associated with the response. Defaults to None.
            data (Optional[T]): The additional data associated with the response. Defaults to None.

        Returns:
            BaseResponse: The created successful response object.
        """
        return BaseResponse(BaseResponse._OK, message, data)

    @staticmethod
    def fail(message: Optional[str] = None, data: Optional[T] = None):
        """
        Create a failed response object.

        Args:
            message (Optional[str]): The message associated with the response. Defaults to None.
            data (Optional[T]): The additional data associated with the response. Defaults to None.

        Returns:
            BaseResponse: The created failed response object.
        """
        return BaseResponse(BaseResponse._FAIL, message, data)
